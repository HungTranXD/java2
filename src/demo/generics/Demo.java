package demo.generics;

public class Demo <S> {
    /*
        S,E: element reference
        N: number
        T: type
        K: key
        V: value
     */
    S element;

    public S getElement() {
        return element;
    }

    public void setElement(S element) {
        this.element = element;
    }

    //generics Method
    public <E> void print(E msg) {
        System.out.println(msg);
    }
}
