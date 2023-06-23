import java.util.Scanner;

public class TokoOnline {
    private String[] produk;
    private double[] harga;
    private int[] stok;

    public TokoOnline() {
        produk = new String[]{"Kemeja", "Celana Jeans", "Sepatu", "Tas"};
        harga = new double[]{75000.0, 110000.0, 150000.0, 145000.0};
        stok = new int[]{25, 10, 15, 20};
    }

    public void tampilkanProduk() {
        System.out.println("Produk Tersedia:");
        for (int i = 0; i < produk.length; i++) {
            System.out.println((i + 1) + ". " + produk[i] + " - Rp" + harga[i]);
        }
    }

    public void tampilkanJumlahStok() {
        System.out.println("Jumlah Stok Barang");
        for (int i = 0; i < produk.length; i++) {
            System.out.println(produk[i] + ": " + stok[i]);
        }
    }

    public boolean cekStok(int indeks, int jumlah) {
        if (indeks >= 0 && indeks < stok.length) {
            return jumlah <= stok[indeks];
        }
        return false;
    }

    public void beliProduk(int indeks, int jumlah) {
        if (indeks >= 0 && indeks < produk.length && cekStok(indeks, jumlah)) {
            double total = harga[indeks] * jumlah;
            System.out.println("Produk: " + produk[indeks]);
            System.out.println("Jumlah: " + jumlah);
            System.out.println("Total: Rp" + total);
            stok[indeks] -= jumlah;
            System.out.println("Pembelian berhasil!");
        } else {
            System.out.println("Produk tidak tersedia atau stok tidak mencukupi.");
        }
    }

    public static void main(String[] args) {
        TokoOnline toko = new TokoOnline();
        toko.tampilkanJumlahStok();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("     Selamat Datang di Toko Online Shop        ");
        System.out.println("         Ada yang bisa kami bantu?             ");
        System.out.println("           Sumberayu Banyuwangi                ");
        System.out.println("           Tlp :(0333) 578 112.                ");
        System.out.println("              Happy Shopping!                    ");
        System.out.println("-----------------------------------------------");

        while (true) {
            System.out.println("1. Tampilkan produk tersedia");
            System.out.println("2. Beli produk");
            System.out.println("3. Tampilkan jumlah stok barang");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    toko.tampilkanProduk();
                    break;
                case 2:
                    System.out.print("Masukkan nomor produk: ");
                    int nomorProduk = scanner.nextInt() - 1;
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();
                    toko.beliProduk(nomorProduk, jumlah);
                    break;
                case 3:
                    toko.tampilkanJumlahStok();
                    break;
                case 4:
                    System.out.println("Terima kasih telah mengunjungi toko online RisaOktora. Sampai jumpa!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi."); 
            }
        }
    }
}