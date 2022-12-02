package interfaces;

import entities.Student;

import java.util.ArrayList;

//DAO pattern
public interface IRepository<E> {
    ArrayList<E> all();
    Boolean create(E s);
    Boolean update(E s);
    Boolean delete(E s);
    E find(int id);
}
