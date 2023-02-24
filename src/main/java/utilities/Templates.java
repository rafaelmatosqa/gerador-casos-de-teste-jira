package utilities;


public class Templates {

    public static String TemplateTestNg(String idTestCase,String TestCaseName, String description)

    {
        return "    @Test\n" +
                "    @TestCase(key=\"" + idTestCase +", description=\"" + description + "\")\n" +
                "    public void test_" + TestCaseName + "(){}\n\n";

    }
}
