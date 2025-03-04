package L5_OOP;

public class D6_ImmutableClass {
    private int core_number;
    private int ram_size;
    private String[] companies;

    public D6_ImmutableClass(int core_number, int ram_size, String[] companies) {
        this.core_number = core_number;
        this.ram_size = ram_size;
        this.companies = companies;
    }

    public int getCore_number() {
        return core_number;
    }

    public int getRam_size() {
        return ram_size;
    }

    public String[] getCompanies() {
        String[] copy_companies = new String[companies.length];
        for (int i = 0; i < companies.length; i++) {
            copy_companies[i] = companies[i];
        }
        return copy_companies;
    }
}
