import java.util.Scanner;

public class MineSweeper {

    int row;
    int col;
    int countOfMine;
    String[][] mineMap;
    String[][] baseMap;

    public MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.countOfMine = (row * col) / 4;
        this.mineMap = new String[row][col];
        this.baseMap = new String[row][col];

    }

    boolean run(int row, int col) {
        Scanner sc = new Scanner(System.in);

        countOfMine = (row * col) / 4;
        System.out.println("Oynamak üzere olduğunuz oyunda toplam : " + countOfMine + " adet mayın bulunmaktadır.");
        mineMap = new String[row][col];
        baseMap = new String[row][col];
        for (int i = 0; i < countOfMine; i++) {
            int x = (int) (Math.random() * row);
            int y = (int) (Math.random() * col);
            //System.out.println("x "+x+" y "+y);
            if (mineMap[x][y] != "*") {
                mineMap[x][y] = "*";
            } else {
                i--;

            }

        } //random mayın yerleri belirlenmesi ve üst üste mayın gelmemesinin kontrolü
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mineMap[i][j] != "*") {
                    mineMap[i][j] = "-";
                }
            }
        } //mayınlı haritada mayınlar haricinde kalan bölümlere - konulması
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(mineMap[i][j]);
//            }
//            System.out.println();
//        } //mayınlı haritanın ekrana bastırılması

       for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
              baseMap[i][j]="/";
           }
       }

       int countOfMinelessArea=(row*col)-countOfMine;

        while (countOfMinelessArea > 0) {
            int countOfNearMine = 0;
            System.out.print("Mayınlı olmadığını düşündüğünüz satırın numarasını belirtiniz : ");
            int rowTahmin = sc.nextInt();
            System.out.println();
            System.out.print("Mayınlı olmadığını düşündüğünüz sütun numarasını belirtiniz : ");
            int colTahmin = sc.nextInt();
            System.out.println("==========================================================");
            if ((((rowTahmin-1) < (row )) || ((rowTahmin-1) >= 0)) && (((colTahmin-1) < col ) || ((colTahmin-1) >= 0))) { //tahmin edilen satır ve sütunun kontrolü
                if (mineMap[rowTahmin - 1][colTahmin - 1] == "*") {
                    System.out.println("Maalesef mayına bastınız ve kaybettiniz");
                    break;

                } else {
                    if ((rowTahmin > 1 && colTahmin > 1) && ((rowTahmin <= (row - 1)) && (colTahmin <= (col - 1)))) {
                        for (int i = (rowTahmin - 2); i <= (rowTahmin); i++) {
                            for (int j = (colTahmin - 2); j <= (colTahmin); j++) {
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;

                        // mayınlı bölgenin dış çerçeve hariç kontrol edilmesi


                    } else if ((rowTahmin == 1)&&(colTahmin > 1)&&(colTahmin<col)) {
                        for(int i=0;i<=1;i++){
                            for(int j=(colTahmin-2);j<=colTahmin;j++){
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                     //[0][0]ve[0][n] haricinde üst sıradan bir seçim yapıldığında yakınındaki mayınları saydırır.
                    }else if((rowTahmin==row)&&(colTahmin > 1)&&(colTahmin<col)){
                        for(int i=row-2;i<row;i++){
                            for(int j=(colTahmin-2);j<=colTahmin;j++){
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                        //[n][0] ve [n][n] hariç alt sıradan bir seçim yapıldığında yakınındaki mayınları saydırır.
                    }else if((colTahmin==1)&&(rowTahmin > 1)&&(rowTahmin<row)){
                        for(int i=(rowTahmin-2);i<rowTahmin;i++){
                            for(int j=0;j<=1;j++){
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                        //[0][0]ve[n][0] haricinde sol sıradan bir seçim yapıldığında yakınındaki mayınları saydırır.
                    }else if((colTahmin==col)&&(rowTahmin > 1)&&(rowTahmin<row)){
                        for(int i=(rowTahmin-2);i<=rowTahmin;i++){
                            for(int j=col-2;j<col;j++){
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                        //[n][n] ve [0][n] haricinde sağ sıradan bir seçim yapıldığında yakınındaki mayınları saydırır.
                    }else if((rowTahmin==1)&&(colTahmin==1)) {
                        for (int i = 0; i <= 1; i++) {
                            for (int j = 0; j <= 1; j++) {
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                        //[0][0] seçim yapıldığında yakınındaki mayınları saydırır.
                    }else if((rowTahmin==row)&&(colTahmin==1)) {
                        for (int i = row - 2; i < row; i++) {
                            for (int j = 0; j <= 1; j++) {
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                        //[n][0] seçim yapıldığında yakınındaki mayınları saydırır.
                    }else if((rowTahmin==1)&&(colTahmin==col)) {
                        for (int i = 0; i <= 1; i++) {
                            for (int j = (col - 2); j <= (col-1); j++) {
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                        //[0][n] seçim yapıldığında yakınındaki mayınları saydırır.
                    }else if((rowTahmin==row)&&(colTahmin==col)) {
                        for (int i = row - 2; i <row; i++) {
                            for (int j = col-2; j <col; j++) {
                                if ((mineMap[rowTahmin-1][colTahmin-1] != mineMap[i][j]) && (mineMap[i][j].equals("*"))) {

                                    countOfNearMine++;
                                }
                            }
                        }
                        String k = String.valueOf(countOfNearMine);
                        System.out.println(k);
                        baseMap[rowTahmin-1][colTahmin-1] = k;
                        //[n][n] seçim yapıldığında yakınındaki mayınları saydırır.
                    }

                    for(int i=0;i<row;i++){
                        for(int j=0;j<col;j++){
                            System.out.print(baseMap[i][j]);
                        }
                        System.out.println();
                    }
                }
            } else break;
            countOfMinelessArea--;
            System.out.println("Kalan Mayınsız Alan Sayısı: " + countOfMinelessArea);
            if(countOfMinelessArea==0){
                System.out.println("Tebrikler Kazandınız");
            }
        }
        return true;
    }
}