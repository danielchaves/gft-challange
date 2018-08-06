package br.com.gft;

import java.util.logging.Logger;

@SpringBootApplication
public class GftTestApplication 
  implements CommandLineRunner {
 
    private static Logger LOG = LoggerFactory
      .getLogger(SpringBootConsoleApplication.class);
 
    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
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