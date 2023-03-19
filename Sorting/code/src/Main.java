public class Main {
    public static void main(String[] args) {
        Questions q = new Questions();

        int[] nums = {2, 3, 4, 5, 6};
        long inversionsCount = q.inversionCount(nums);
        System.out.println(inversionsCount);
    }
}
