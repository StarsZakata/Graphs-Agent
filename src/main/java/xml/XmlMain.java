package xml;

public class XmlMain {
    public static void main(String[] args) {
//        MyConfig cfg = new MyConfig();
//        cfg.setPath("d://work//myproject");
//        cfg.setQuantity(3);
//        cfg.setAddresses(
//                Arrays.asList(
//                        new Address("127.0.0.1", "7070"),
//                        new Address("127.0.0.1", "8070"),
//                        new Address("127.0.0.1", "8080")
//                )
//        );
//
//        XmlHelper.marshalAny(cfg, "a.xml");
        MyConfig myConfig = XmlHelper.unMarshalAny(MyConfig.class, "a.xml");
        System.out.println();
    }
}
