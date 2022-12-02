package factory;

import enums.RepoType;
import impls.ClassesRepository;
import impls.StudentRepository;
import interfaces.IRepository;

public class Factory {
    public static IRepository createRepository(RepoType type) throws IllegalArgumentException{
        switch (type) {
            case STUDENT: return new StudentRepository();
            case CLASSES: return new ClassesRepository();
            default: throw new IllegalArgumentException("Class not found");
        }
    }
}
