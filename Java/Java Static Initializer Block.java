private static int B;
private static int H;
private static boolean flag;
static{
    Scanner scan = new Scanner(System.in);
    B = scan.nextInt();
    H = scan.nextInt();

    if(B>0 && H>0){
        flag = true;
    }
    else{
        System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
}

