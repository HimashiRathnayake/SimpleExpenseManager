package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.Database;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.InMemoryAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.InMemoryTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.StoreAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.StoreTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;

public class StoreExpenseManager extends ExpenseManager{
    private Database db;
    public StoreExpenseManager(Database db) {
        this.db = db;
        setup();
    }

    @Override
    public void setup() {

        TransactionDAO persistentTransactionDAO = new StoreTransactionDAO(db);
        setTransactionsDAO(persistentTransactionDAO);

        AccountDAO persistentAccountDAO = new StoreAccountDAO(db);
        setAccountsDAO(persistentAccountDAO);

    }
}
