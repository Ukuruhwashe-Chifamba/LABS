// Ex 7.2 (Basic)
public class ArrayAccess {
    static int safeGet(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is outside 0.." + (arr.length - 1));
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] data = {10, 20, 30};
        System.out.println(safeGet(data, 1));
        System.out.println(safeGet(data, 5));
    }
}
