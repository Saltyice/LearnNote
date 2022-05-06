package generic;


//子类如果继承了指定泛型的父类则不再需要指定泛型
//public class SubMyGeneric extends MyGeneric<Integer>{
//}
//如果父类没指定泛型，则子类仍然是泛型
public class SubMyGeneric<E> extends MyGeneric<E>{
}