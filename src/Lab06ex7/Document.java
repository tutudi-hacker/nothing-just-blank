package Lab06ex7;

public abstract class Document {
    public final void generate() {
        write_header();
        write_body();
        write_footer();
        System.out.println("----------------------------------------");
    }

    protected abstract void write_header();
    protected abstract void write_body();
    protected abstract void write_footer();

    public static void main(String[] args) {
        Document invoice = new InvoiceDocument();
        Document resume = new ResumeDocument();
        Document report = new ReportDocument();

        invoice.generate();
        resume.generate();
        report.generate();
    }
}

class InvoiceDocument extends Document {
    @Override
    protected void write_header() {
        System.out.println("=== INVOICE #2026-089 ===");
    }

    @Override
    protected void write_body() {
        System.out.println("Items: Laptop ($1200.00), Mouse ($25.00)");
        System.out.println("Total Due: $1225.00");
    }

    @Override
    protected void write_footer() {
        System.out.println("Thank you for your business. Payment due in 30 days.");
    }
}

class ResumeDocument extends Document {
    @Override
    protected void write_header() {
        System.out.println("=== JANE DOE | SOFTWARE ENGINEER ===");
    }

    @Override
    protected void write_body() {
        System.out.println("Experience: 4 years in Java & Cloud Architecture.");
        System.out.println("Skills: Java, Spring Boot, SQL, Docker.");
    }

    @Override
    protected void write_footer() {
        System.out.println("Contact: jane.doe@example.com | GitHub: ://github.com");
    }
}

class ReportDocument extends Document {
    @Override
    protected void write_header() {
        System.out.println("=== Q4 ANNUAL PERFORMANCE REPORT ===");
    }

    @Override
    protected void write_body() {
        System.out.println("Revenue increased by 18% compared to Q3.");
        System.out.println("Customer retention reached 94%.");
    }

    @Override
    protected void write_footer() {
        System.out.println("Confidential - Internal Distribution Only");
    }
}
