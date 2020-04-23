//package searchreplace;
import java.io.File;
import java.io.FileNotFoundException;

abstract class Observer {
    public abstract void update(String file) throws FileNotFoundException;
    public String file;
}
