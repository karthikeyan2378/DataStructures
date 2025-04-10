package LLD.SplitWise;

import java.util.*;

class User {
    private String userId;
    private String name;
    private String email;
    private String mobile;

    public User(String userId, String name, String email, String mobile) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getUserId() {
        return userId;
    }
}

class Expense {
    enum ExpenseType { EQUAL, EXACT, PERCENT }

    private String paidBy;
    private double amount;
    private List<String> participants;
    private ExpenseType type;
    private List<Double> shares;

    public Expense(String paidBy, double amount, List<String> participants, ExpenseType type, List<Double> shares) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.participants = participants;
        this.type = type;
        this.shares = shares;
    }

    public String getPaidBy() { return paidBy; }
    public double getAmount() { return amount; }
    public List<String> getParticipants() { return participants; }
    public ExpenseType getType() { return type; }
    public List<Double> getShares() { return shares; }
}

class ExpenseService {
    private Map<String, Map<String, Double>> balanceSheet;

    public ExpenseService() {
        this.balanceSheet = new HashMap<>();
    }

    public void addExpense(Expense expense) {
        String paidBy = expense.getPaidBy();
        List<String> participants = expense.getParticipants();
        List<Double> shares = expense.getShares();
        double amount = expense.getAmount();
        Expense.ExpenseType type = expense.getType();

        switch (type) {
            case EQUAL:
                distributeEqual(paidBy, participants, amount);
                break;
            case EXACT:
                distributeExact(paidBy, participants, shares);
                break;
            case PERCENT:
                distributePercent(paidBy, participants, amount, shares);
                break;
        }
    }

    private void distributeEqual(String paidBy, List<String> participants, double amount) {
        double share = Math.round((amount / participants.size()) * 100.0) / 100.0;

        for (String user : participants) {
            if (!user.equals(paidBy)) updateBalance(user, paidBy, share);
        }
    }

    private void distributeExact(String paidBy, List<String> participants, List<Double> shares) {
        for (int i = 0; i < participants.size(); i++) {
            if (!participants.get(i).equals(paidBy)) updateBalance(participants.get(i), paidBy, shares.get(i));
        }
    }

    private void distributePercent(String paidBy, List<String> participants, double amount, List<Double> shares) {
        double totalPercent = shares.stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalPercent - 100) > 0.01) {
            throw new IllegalArgumentException("Percentages must sum to 100%");
        }

        for (int i = 0; i < participants.size(); i++) {
            if (!participants.get(i).equals(paidBy)) {
                double share = Math.round((amount * shares.get(i) / 100) * 100.0) / 100.0;
                updateBalance(participants.get(i), paidBy, share);
            }
        }
    }

    private void updateBalance(String debtor, String creditor, double amount) {
        balanceSheet.putIfAbsent(debtor, new HashMap<>());
        balanceSheet.putIfAbsent(creditor, new HashMap<>());

        double existingDebt = balanceSheet.get(debtor).getOrDefault(creditor, 0.0);
        double existingCredit = balanceSheet.get(creditor).getOrDefault(debtor, 0.0);

        double netAmount = existingDebt + amount - existingCredit;

        if (netAmount > 0) {
            balanceSheet.get(debtor).put(creditor, netAmount);
            balanceSheet.get(creditor).remove(debtor);
        } else {
            balanceSheet.get(creditor).put(debtor, -netAmount);
            balanceSheet.get(debtor).remove(creditor);
        }
    }

    public Map<String, Map<String, Double>> getBalanceSheet() {
        return balanceSheet;
    }
}

class BalanceService {
    private ExpenseService expenseService;

    public BalanceService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void showBalances() {
        Map<String, Map<String, Double>> balances = expenseService.getBalanceSheet();
        boolean hasBalance = false;

        for (String user : balances.keySet()) {
            for (Map.Entry<String, Double> entry : balances.get(user).entrySet()) {
                System.out.println(user + " owes " + entry.getKey() + ": " + entry.getValue());
                hasBalance = true;
            }
        }

        if (!hasBalance) System.out.println("No balances");
    }

    public void showUserBalance(String userId) {
        Map<String, Map<String, Double>> balances = expenseService.getBalanceSheet();
        boolean hasBalance = false;

        if (balances.containsKey(userId)) {
            for (Map.Entry<String, Double> entry : balances.get(userId).entrySet()) {
                System.out.println(userId + " owes " + entry.getKey() + ": " + entry.getValue());
                hasBalance = true;
            }
        }

        for (String user : balances.keySet()) {
            if (balances.get(user).containsKey(userId)) {
                System.out.println(user + " owes " + userId + ": " + balances.get(user).get(userId));
                hasBalance = true;
            }
        }

        if (!hasBalance) System.out.println("No balances");
    }
}

public class SplitWise {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();
        BalanceService balanceService = new BalanceService(expenseService);

        balanceService.showBalances();
        balanceService.showUserBalance("u1");

        expenseService.addExpense(new Expense("u1", 1000, Arrays.asList("u1", "u2", "u3", "u4"), Expense.ExpenseType.EQUAL, null));
        balanceService.showUserBalance("u4");

        expenseService.addExpense(new Expense("u1", 1250, Arrays.asList("u2", "u3"), Expense.ExpenseType.EXACT, Arrays.asList(370.0, 880.0)));
        balanceService.showBalances();

        expenseService.addExpense(new Expense("u4", 1200, Arrays.asList("u1", "u2", "u3", "u4"), Expense.ExpenseType.PERCENT, Arrays.asList(40.0, 20.0, 20.0, 20.0)));
        balanceService.showUserBalance("u1");
        balanceService.showBalances();
    }
}
