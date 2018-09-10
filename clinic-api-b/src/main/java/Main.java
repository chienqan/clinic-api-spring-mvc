import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PatientService;
import service.PrescriptionService;
import service.VisitService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

        context.refresh();



        PatientService patientService = context.getBean(PatientService.class);
        PrescriptionService prescriptionService = context.getBean(PrescriptionService.class);
        VisitService visitService = context.getBean(VisitService.class);

    }
}
