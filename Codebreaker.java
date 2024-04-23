import java.util.ArrayList;
import java.util.Arrays;
public class Codebreaker {
    public static void main(String[] args){
        String Code = "6on5p81234x72349 7va443583 9zl16 2q22912n7l46 54j385r86347 29q13v32q44 2ab9531368721796348g254437265 u8n91i8r 153947269gu6b3281f27r43443519 82r7z56bwvpba3f4726962817345";     
        ArrayList<Integer> key = new ArrayList<Integer>(Arrays.asList(6,5,8,1,2,3,4,7,9,7,4,3,5,8,9,1,6,2,2,9,1,7,4,6,5,3,8,5,8,6,4,7,2,9,1,3,3,2,4,9,5,1,6,8,7,1,7,9,6,3,8,2,5,4,4,3,7,2,6,5,8,9,1,8,1,5,3,9,4,7,2,6,9,6,2,8,1,7,3,4,5));
        int keyPlace = 0;
        int i = 0;
        for (char x : Code.toCharArray()){

            try {
            i = Integer.parseInt(String.valueOf(x));
           // System.out.println("Integer:" + Integer.parseInt(String.valueOf(x)));
            //System.out.println("KeyPlace: " + key.get(keyPlace));
            }catch (Exception e){
                
            }
            if (keyPlace == key.size()){
                System.exit(0);
            }

            if (i == key.get(keyPlace)){

              //  System.out.println("\nremoving " + x);
             // System.out.println();
                keyPlace++;

            }else{

            System.out.print(x);
          }
            i = 0;
        }

        }
    }
    

