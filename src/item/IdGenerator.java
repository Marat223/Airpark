package item;

public class IdGenerator {

    private IdGenerator() {
    }

    private static int id = 0;

    public int setNewId(Item item) {
        item.setId(++id);
        return id;
    }

    public static IdGenerator getInstance() {
        return InstanceCreatorHolder.INSTANCE;
    }

    private static class InstanceCreatorHolder {

        private static final IdGenerator INSTANCE = new IdGenerator();

    }
}
