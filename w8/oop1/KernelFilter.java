import java.awt.Color;

public class KernelFilter {
    public static Picture identity(Picture picture) {
        int w = picture.width();
        int h = picture.height();
        Picture iden = new Picture(w, h);
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                iden.set(col, row, picture.get(col, row));
            }
        }
        return iden;
    }

    public static Picture gaussian(Picture picture) {
        int w = picture.width();
        int h = picture.height();
        Picture gaus = new Picture(w, h);
        Color[] c = new Color[9];
        int[][] rgb = new int[3][10];
        int left, right, above, below;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i == 0) left = w - 1;
                else left = i - 1;
                if (i == w - 1) right = 0;
                else right = i + 1;
                if (j == 0) above = h - 1;
                else above = j - 1;
                if (j == h - 1) below = 0;
                else below = j + 1;
                c[0] = picture.get(left, above);
                c[1] = picture.get(i, above);
                c[2] = picture.get(right, above);
                c[3] = picture.get(left, j);
                c[4] = picture.get(i, j);
                c[5] = picture.get(right, j);
                c[6] = picture.get(left, below);
                c[7] = picture.get(i, below);
                c[8] = picture.get(right, below);
                for (int k = 0; k < 9; k++) {
                    rgb[0][k] = c[k].getRed();
                    rgb[1][k] = c[k].getGreen();
                    rgb[2][k] = c[k].getBlue();
                }
                for (int k = 0; k < 3; k++) {
                    rgb[k][9] = (int) (Math.round((rgb[k][0] + 2 * rgb[k][1] + rgb[k][2] + 2 * rgb[k][3] + 4 * rgb[k][4] + 2 * rgb[k][5] + rgb[k][6] + 2 * rgb[k][7] + rgb[k][8]) / 16.0));
                    if (rgb[k][9] > 255) rgb[k][9] = 255;
                    if (rgb[k][9] < 0) rgb[k][9] = 0;
                }
                Color ct = new Color(rgb[0][9], rgb[1][9], rgb[2][9]);
                gaus.set(i, j, ct);
            }
        }
        return gaus;
    }

    public static Picture sharpen(Picture picture) {
        int w = picture.width();
        int h = picture.height();
        Picture shar = new Picture(w, h);
        Color[] c = new Color[5];
        int[][] rgb = new int[3][6];
        int left, right, above, below;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i == 0) left = w - 1;
                else left = i - 1;
                if (i == w - 1) right = 0;
                else right = i + 1;
                if (j == 0) above = h - 1;
                else above = j - 1;
                if (j == h - 1) below = 0;
                else below = j + 1;
                c[0] = picture.get(i, above);
                c[1] = picture.get(left, j);
                c[2] = picture.get(i, j);
                c[3] = picture.get(right, j);
                c[4] = picture.get(i, below);
                for (int k = 0; k < 5; k++) {
                    rgb[0][k] = c[k].getRed();
                    rgb[1][k] = c[k].getGreen();
                    rgb[2][k] = c[k].getBlue();
                }
                for (int k = 0; k < 3; k++) {
                    rgb[k][5] = -rgb[k][0] - rgb[k][1] + 5 * rgb[k][2] - rgb[k][3] - rgb[k][4];
                    if (rgb[k][5] > 255) rgb[k][5] = 255;
                    if (rgb[k][5] < 0) rgb[k][5] = 0;
                }
                Color ct = new Color(rgb[0][5], rgb[1][5], rgb[2][5]);
                shar.set(i, j, ct);
            }
        }
        return shar;
    }

    public static Picture laplacian(Picture picture) {
        int w = picture.width();
        int h = picture.height();
        Picture lap = new Picture(w, h);
        Color[] c = new Color[9];
        int[][] rgb = new int[3][10];
        int left, right, above, below;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i == 0) left = w - 1;
                else left = i - 1;
                if (i == w - 1) right = 0;
                else right = i + 1;
                if (j == 0) above = h - 1;
                else above = j - 1;
                if (j == h - 1) below = 0;
                else below = j + 1;
                c[0] = picture.get(left, above);
                c[1] = picture.get(i, above);
                c[2] = picture.get(right, above);
                c[3] = picture.get(left, j);
                c[4] = picture.get(i, j);
                c[5] = picture.get(right, j);
                c[6] = picture.get(left, below);
                c[7] = picture.get(i, below);
                c[8] = picture.get(right, below);
                for (int k = 0; k < 9; k++) {
                    rgb[0][k] = c[k].getRed();
                    rgb[1][k] = c[k].getGreen();
                    rgb[2][k] = c[k].getBlue();
                }
                for (int k = 0; k < 3; k++) {
                    rgb[k][9] = -rgb[k][0] - rgb[k][1] - rgb[k][2] - rgb[k][3] + 8 * rgb[k][4] - rgb[k][5] - rgb[k][6] - rgb[k][7] - rgb[k][8];
                    if (rgb[k][9] > 255) rgb[k][9] = 255;
                    if (rgb[k][9] < 0) rgb[k][9] = 0;
                }
                Color ct = new Color(rgb[0][9], rgb[1][9], rgb[2][9]);
                lap.set(i, j, ct);
            }
        }
        return lap;
    }


    public static Picture emboss(Picture picture) {
        int w = picture.width();
        int h = picture.height();
        Picture emb = new Picture(w, h);
        Color[] c = new Color[9];
        int[][] rgb = new int[3][10];
        int left, right, above, below;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i == 0) left = w - 1;
                else left = i - 1;
                if (i == w - 1) right = 0;
                else right = i + 1;
                if (j == 0) above = h - 1;
                else above = j - 1;
                if (j == h - 1) below = 0;
                else below = j + 1;
                c[0] = picture.get(left, above);
                c[1] = picture.get(i, above);
                c[2] = picture.get(right, above);
                c[3] = picture.get(left, j);
                c[4] = picture.get(i, j);
                c[5] = picture.get(right, j);
                c[6] = picture.get(left, below);
                c[7] = picture.get(i, below);
                c[8] = picture.get(right, below);
                for (int k = 0; k < 9; k++) {
                    rgb[0][k] = c[k].getRed();
                    rgb[1][k] = c[k].getGreen();
                    rgb[2][k] = c[k].getBlue();
                }
                for (int k = 0; k < 3; k++) {
                    rgb[k][9] = (-2) * rgb[k][0] - rgb[k][1] - rgb[k][3] + rgb[k][4] + rgb[k][5] + rgb[k][7] + 2 * rgb[k][8];
                    if (rgb[k][9] > 255) rgb[k][9] = 255;
                    if (rgb[k][9] < 0) rgb[k][9] = 0;
                }
                Color ct = new Color(rgb[0][9], rgb[1][9], rgb[2][9]);
                emb.set(i, j, ct);
            }
        }
        return emb;
    }

    public static Picture motionBlur(Picture picture) {
        int w = picture.width();
        int h = picture.height();
        Picture mot = new Picture(w, h);
        Color[] c = new Color[10];
        int[][] rgb = new int[3][10];
        int[] col = new int[9];
        int[] row = new int[9];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < 9; k++) {
                    col[k] = i + k - 4;
                    while (col[k] < 0) col[k] = col[k] + w;
                    while (col[k] >= w) col[k] = col[k] - w;
                    row[k] = j + k - 4;
                    while (row[k] < 0) row[k] = row[k] + h;
                    while (row[k] >= h) row[k] = row[k] - h;
                    c[k] = picture.get(col[k], row[k]);
                    rgb[0][k] = c[k].getRed();
                    rgb[1][k] = c[k].getGreen();
                    rgb[2][k] = c[k].getBlue();
                }
                for (int k = 0; k < 3; k++) {
                    rgb[k][9] = 0;
                    for (int l = 0; l < 9; l++) rgb[k][9] = rgb[k][9] + rgb[k][l];
                    rgb[k][9] = (int) (Math.round(rgb[k][9] / 9.0));
                    if (rgb[k][9] > 255) rgb[k][9] = 255;
                    if (rgb[k][9] < 0) rgb[k][9] = 0;
                }
                Color ct = new Color(rgb[0][9], rgb[1][9], rgb[2][9]);
                mot.set(i, j, ct);
            }
        }
        return mot;
    }

    public static void main(String[] args) {
        Picture origin = new Picture(args[0]);
        Picture pic1 = identity(origin);
        Picture pic2 = gaussian(origin);
        Picture pic3 = sharpen(origin);
        Picture pic4 = laplacian(origin);
        Picture pic5 = emboss(origin);
        Picture pic6 = motionBlur(origin);
        pic6.show();
    }

}
