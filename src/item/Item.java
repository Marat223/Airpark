package item;


public interface Item {
    
    default void setId(int id) throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Unimplemented exception: \"item.setId(int id)\"");
    }

    public void doBusinessAction();

}