package designProblemsAndGames.splitwise.user;

/**
 * One settled-up-to-date obligation, read off a group's balance map.
 * Always stated in the direction that makes amount positive: debtor owes creditor.
 */
public record Debt(User debtor, User creditor, double amount) {
}