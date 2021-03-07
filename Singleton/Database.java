package as6.Singleton;


class Database {

    private static Database instance;


    private Database() {

    }

    public static Database getInstance() {
        if (Database.instance == null)
            acquireThreadLock(Database.class);
        {
            if (Database.instance == null)
                Database.instance = new Database();
        }
        return Database.instance;
    }

    private static void acquireThreadLock(Class<Database> databaseClass) {
    }

    public String getUser() {
        return "Murzashev_Ernest";
    }

}


