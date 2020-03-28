public class Employee_main {

        public static void main(String[] args) {
            //method -1
            //StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            //Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
            //SessionFactory factory = meta.getSessionFactoryBuilder().build();

            Data_operations d = new Data_operations();
             d.generate_data();
            d.print_data();
            d.update_data_byname("user1","user101");
            d.delete_byname("user1");
        }





    }


