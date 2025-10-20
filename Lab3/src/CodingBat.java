public class CodingBat {
    public int arrayCount9(int[] nums) {
        int suma = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 9){
                suma++;
            }
        }
        return suma;
    }

    public static void main(){
        CodingBat cod = new CodingBat();
        cod.arrayCount9(new int[] {1, 2, 9});
        cod.arrayCount9(new int [] {1, 9, 9});
        cod.arrayCount9(new int [] {1, 9, 9, 3, 9});
        cod.arrayCount9(new int []{});
        cod.arrayCount9(new int []{4, 2, 4, 3, 1});
        cod.arrayCount9(new int [] {9, 2, 4, 3, 1});
    }
}

