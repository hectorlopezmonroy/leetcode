/*
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

class IntegerToRoman {

    public static String processThousands(int num) {
        String res = "";
        if (num >= 1000) {
            int n = (int) (num % 10000) / 1000;
            if (n <= 3) {
                for (int i = 0; i < n; i++) {
                    res = res.concat("M");
                }
            }
        }
        return res;
    }

    public static String processHundreds(int num) {
        String res = "";
        if (num >= 100) {
            int n = (int) (num % 1000) / 100;
            if (1 <= n && n <= 3) {
                for (int i = 0; i < n; i++) {
                    res = res.concat("C");
                }
            } else if (n == 4) {
                res = "CD";
            } else if (n == 5) {
                res = "D";
            } else if (6 <= n && n <= 8) {
                res = "D";
                for (int i = 0; i < n - 5; i++) {
                    res = res.concat("C");
                }
            } else if (n == 9) {
                res = "CM";
            }
        }
        return res;
    }

    public static String processTens(int num) {
        String res = "";
        if (num >= 10) {
            int n = (int) (num % 100) / 10;
            if (1 <= n && n <= 3) {
                for (int i = 0; i < n; i++) {
                    res = res.concat("X");
                }
            } else if (n == 4) {
                res = "XL";
            } else if (n == 5) {
                res = "L";
            } else if (6 <= n && n <= 8) {
                res = "L";
                for (int i = 0; i < n - 5; i++) {
                    res = res.concat("X");
                }
            } else if (n == 9) {
                res = "XC";
            }
        }
        return res;
    }

    public static String processUnits(int num) {
        String res = "";
        if (num >= 1) {
            int n = (int) num % 10;
            if (1 <= n && n <= 3) {
                for (int i = 0; i < n; i++) {
                    res = res.concat("I");
                }
            } else if (n == 4) {
                res = "IV";
            } else if (n == 5) {
                res = "V";
            } else if (6 <= n && n <= 8) {
                res = "V";
                for (int i = 0; i < n - 5; i++) {
                    res = res.concat("I");
                }
            } else if (n == 9) {
                res = "IX";
            }
        }
        return res;
    }

    public static String getGreaterRomanLiteral(int num) {
        String res = "";

        if (1000 <= num) {
            res = "M";
        } else if (500 <= num && num <= 999) {
            res = "D";
        } else if (100 <= num && num <= 499) {
            res = "C";
        } else if (50 <= num && num <= 99) {
            res = "L";
        } else if (10 <= num && num <= 49) {
            res = "X";
        } else if (5 <= num && num <= 9) {
            res = "V";
        } else if (1 <= num && num <= 4) {
            res = "I";
        }
        return res;
    }

    public static int romanLiteralToInt(String c) {
        int res = 0;

        if (c == "M") {
            res = 1000;
        } else if (c == "D") {
            res = 500;
        } else if (c == "C") {
            res = 100;
        } else if (c == "L") {
            res = 50;
        } else if (c == "X") {
            res = 10;
        } else if (c == "V") {
            res = 5;
        } else if (c == "I") {
            res = 1;
        }
        return res;
    }

    public static String intToRoman(int num) {
        String res = "";

        if (num - romanLiteralToInt(getGreaterRomanLiteral(num)) == 0) {
            res = getGreaterRomanLiteral(num);
        } else {
            if (num >= 1000) {
                res = res.concat(processThousands(num));
                num = num - (((num % 10000) / 1000) * 1000);
            }
            if (num >= 100) {
                res = res.concat(processHundreds(num));
                num = num - (((num % 1000) / 100) * 100);
            }
            if (num >= 10) {
                res = res.concat(processTens(num));
                num = num - (((num % 100) / 10) * 10);
            }
            if (num >= 1) {
                res = res.concat(processUnits(num));
                num = num - (num % 10);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 3999; i++) {
            System.out.println("Integer " + i + " is equal to "
                    + intToRoman(i) + ".");
        }
    }
}
