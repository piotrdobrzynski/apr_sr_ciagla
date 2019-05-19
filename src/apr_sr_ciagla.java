public class apr_sr_ciagla {

    static double s[][] = new double[3][3];
    static double a[] = new double[3];
    static double b[] = new double[3];
    static double n,gr_a,gr_b,iii;

    public static double fun(double x) {
        return (Math.sqrt(x));
        // (Math.sqrt(6*(Math.pow(x,2))+7)) dobra funkcja
    }


    static double z;
    public static double funkcja(double xi) {

        z = Math.pow(xi,iii);
     //   System.out.println(xi+" "+iii+" "+z);
        return z;
    }
    public static double calka(){
        double a, b, h, wyn, x, t, xi, xii, n;

        //granice calkowania
        a = gr_a;
        b = gr_b;

        //ilosc punktow
        n = 20;

        h = (b - a) / n;

        x = 0;
        t = 0;
        for (int i=1; i<n; i++) {
            xi = a + i*h;
            xii = a + (i-1)*h;
            t += funkcja((xi+xii)/2);
            x += funkcja(xi);
        }
        t+= funkcja(b - h /2);
        wyn = (h/6) * (funkcja(a) + funkcja(b) + 2*x + 4*t);
        return wyn;

    }

    static double o;
    public static double funkcja_b(double xi) {

        o = Math.pow(xi,iii)*fun(xi);
        //   System.out.println(xi+" "+iii+" "+z);
        return o;
    }
    public static double calka_b(){
        double a, b, h, wyn, x, t, xi, xii, n;

        //granice calkowania
        a = gr_a;
        b = gr_b;

        //ilosc punktow
        n = 20;

        h = (b - a) / n;

        x = 0;
        t = 0;
        for (int i=1; i<n; i++) {
            xi = a + i*h;
            xii = a + (i-1)*h;
            t += funkcja_b((xi+xii)/2);
            x += funkcja_b(xi);
        }
        t+= funkcja_b(b - h /2);
        wyn = (h/6) * (funkcja_b(a) + funkcja_b(b) + 2*x + 4*t);
        return wyn;

    }





    public static double[] solve(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

    public static void apr(){

        for (int i=0;i<n+1;i++){
            for (int j=0;j<n+1;j++){
                iii = i+j;
                s[i][j] = calka();
           //     System.out.println(calka()+" "+i+" "+j);
            }
        }

        for (int i=0;i<n+1;i++){
            iii = i;
            b[i] = calka_b();
        }
    }

    public static void pokaz(){

        for (int i=0;i<n+1;i++){
            for (int j=0;j<n+1;j++){
                System.out.print(s[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i=0;i<n+1;i++){
            System.out.println(b[i]);
        }

        System.out.println();
    }

    public static void wyn(double x){

        double wyn=0;
        for (int i=0;i<n+1;i++){
            wyn += a[i]*Math.pow(x,i);
        }
        System.out.println(wyn);
    }




    public static void main(String[] args) {

        n = 2; // stopien wielomianu
        gr_a = 1; // granica dolna
        gr_b = 3; // granica gorna
        apr();
        pokaz();
        a = solve(s,b);
        wyn(2);

    }
}
