package exception;

/***
 *
 *   异常练习
 *
 *
 *
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            int result = ecm(i,j);
        } catch (NumberFormatException e){
            System.out.println(1);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(2);
        } catch (ArithmeticException e){
            System.out.println(3);
        } catch (MyException e){
            System.out.println(e.getMessage());
        } finally {

        }

    }


    public static int ecm(int i, int j) throws MyException {
        if (i<0 || j<0){
            throw new MyException("XXX");
        }
        return i / j;
    }
}
