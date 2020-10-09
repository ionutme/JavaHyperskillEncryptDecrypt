package encryptdecrypt;

public class Input {
    final String mode;
    final int key;
    final String data;
    final String in;
    final String out;
    final String algorithm;

    Input(String[] args) {
        this.mode = extract(args, "MODE", "enc");
        this.key = Integer.parseInt(extract(args, "KEY", "0"));
        this.data = extract(args, "DATA", null);
        this.in = extract(args, "IN", null);
        this.out = extract(args, "OUT", null);
        this.algorithm = extract(args, "ALG", "shift");
    }

    private static String extract(String[] args, String arg, String defaultValue) {
        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i].substring(1).equalsIgnoreCase(arg)) {
                return args[i + 1];
            }
        }

        return defaultValue;
    }
}
