package Datastructs;

/**
 * Methods that every single list has to implement.
 * @author zyoruk, jeukel
 *
 * @param <K> 
 */
public interface ListInterface<K> {
	public int length();
	public boolean isEmpty();
    public boolean append(K pk);
    public boolean delete(K pk);
    public boolean delete();
    public boolean exists(K pk);
    public boolean insert(int pos, K pk);
    public boolean insert(K pk);
    public boolean clear();
    public boolean cut();
    public K getData();
    public K getTailData();
    public String describe();
}
