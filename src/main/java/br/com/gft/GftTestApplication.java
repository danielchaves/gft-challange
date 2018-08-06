package br.com.gft;

@SpringBootApplication
public class GftTestApplication 
  implements CommandLineRunner {
 
    private static Logger LOG = LoggerFactory
      .getLogger(GftTestApplication.class);
 
    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        GftTestApplication.run(GftTestApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
  
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
  
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }
}