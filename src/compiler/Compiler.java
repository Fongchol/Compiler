package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compiler {
    public static void main(String[] args) throws IOException {

        URL resource = Compiler.class.getClassLoader().getResource("c-charp");
        BufferedReader br = new BufferedReader(new FileReader(new File(resource.getPath())));
       String line = null;
        while ((line = br.readLine()) != null) {
            generateToken(line);
            System.out.println();
        }
        br.close();


//  String command = "while ( 5000 < i ) i = i + 2 ;";

    }

    private static void generateToken(String command) {
        StringTokenizer st = new StringTokenizer(command, " ");
        while (st.hasMoreElements()) {
            String word = String.valueOf(st.nextElement());
            String token = getToken(word);
            System.out.print("\""+ token +"\" ");
            if("T_COMMENT".equals(token)){
                break;
            }
        }
    }

    private static String getToken(String word) {
        if(testReservedWord(word)){
            return getTokenName(word);
        }else if(testNumber(word)){
            return "T_NUMBER";
        }else if(testIndentifier(word)){
            return "T_INDENT";
        }else if(testComment(word)){
            return "T_COMMENT";
        }

        return word;
    }

    private static boolean testReservedWord(String word){
        String pattern = "while|do|while|&&";
        Pattern p = Pattern.compile(pattern);//. represents single character.
        Matcher m = p.matcher(word);
        return m.matches();
    }

    private static boolean testNumber(String word){
        String pattern = "\\d+";
        Pattern p = Pattern.compile(pattern);//. represents single character.
        Matcher m = p.matcher(word);
        return m.matches();
    }

    private static boolean testIndentifier(String word){
        String pattern = "^\\w+";
        Pattern p = Pattern.compile(pattern);//. represents single character.
        Matcher m = p.matcher(word);
        return m.matches();
    }

    private static boolean testComment(String word){
        String pattern = "^\\/\\/.*";
        Pattern p = Pattern.compile(pattern);//. represents single character.
        Matcher m = p.matcher(word);
        return m.matches();
    }

    //reserved word
    private static String getTokenName(String word){
        if("while".equals(word)) return "T_WHILE";
        else if("do".equals(word)) return "T_DO";
        else if("bool".equals(word)) return "T_BOOLEAN";
        else if("int".equals(word)) return "T_INTEGER";
        else if("true".equals(word)) return "T_TRUE";
        else if("abstract".equals(word)) return "T_ABSTRACT";
        else if("as".equals(word)) return "T_AS";
        else if("ิbase".equals(word)) return "T_BASE";
        else if("break".equals(word)) return "T_BREAK";
        else if("byte".equals(word)) return "T_BYTE";
        else if("case".equals(word)) return "T_CASE";
        else if("catch".equals(word)) return "T_CATCH";
        else if("char".equals(word)) return "T_CHAR";
        else if("checked".equals(word)) return "T_CHECKED";
        else if("class".equals(word)) return "T_CLASS";
        else if("const".equals(word)) return "T_CONST";
        else if("continue".equals(word)) return "T_CONTINUE";
        else if("decimal".equals(word)) return "T_DECIMAL";
        else if("default".equals(word)) return "T_DEFAULT";
        else if("delegate".equals(word)) return "T_DELEGATE";
        else if("double".equals(word)) return "T_DOUBLE";
        else if("else".equals(word)) return "T_ELSE";
        else if("enum".equals(word)) return "T_ENUM";
        else if("event".equals(word)) return "T_EVENT";
        else if("explicit".equals(word)) return "T_EXPLICIT";
        else if("extern".equals(word)) return "T_EXTERN";
        else if("false".equals(word)) return "T_FLASE";
        else if("finally".equals(word)) return "T_FINALLY";
        else if("fixed".equals(word)) return "T_FIXED";
        else if("float".equals(word)) return "T_FLOAT";
        else if("for".equals(word)) return "T_FOR";
        else if("foreach".equals(word)) return "T_FOREACH";
        else if("goto".equals(word)) return "T_GOTO";
        else if("if".equals(word)) return "T_IF";
        else if("implicit".equals(word)) return "T_IMPLICIT";
        else if("internal".equals(word)) return "T_INTERNAL";
        else if("is".equals(word)) return "T_IS";
        else if("lock".equals(word)) return "T_LOCK";
        else if("long".equals(word)) return "T_LONG";
        else if("namespace".equals(word)) return "T_NAMESPACE";
        else if("new".equals(word)) return "T_NEW";
        else if("null".equals(word)) return "T_NULL";
        else if("object".equals(word)) return "T_OBJECT";
        else if("operator".equals(word)) return "T_OPERATOR";
        else if("out".equals(word)) return "T_OUT";
        else if("out(generic modifier)".equals(word)) return "T_OUT_GENERIC_MODIFIER";
        else if("override".equals(word)) return "T_OVERRIDE";
        else if("params".equals(word)) return "T_PARAMS";
        else if("private".equals(word)) return "T_PRIVATE";
        else if("protected".equals(word)) return "T_PROTECTED";
        else if("public".equals(word)) return "T_PUBLIC";
        else if("readonly".equals(word)) return "T_READONLY";
        else if("ref".equals(word)) return "T_REF";
        else if("return".equals(word)) return "T_RETURN";
        else if("sbyte".equals(word)) return "T_SBYTE";
        else if("sealed".equals(word)) return "T_SEALED";
        else if("short".equals(word)) return "T_SHORT";
        else if("sizeof".equals(word)) return "T_SIZEOF";
        else if("stackalloc".equals(word)) return "T_STACKALLOC";
        else if("static".equals(word)) return "T_STATIC";
        else if("string".equals(word)) return "T_STRING";
        else if("struct".equals(word)) return "T_STRUCT";
        else if("switch".equals(word)) return "T_SWITCH";
        else if("this".equals(word)) return "T_THIS";
        else if("throw".equals(word)) return "T_THROW";
        else if("true".equals(word)) return "T_TRUE";
        else if("try".equals(word)) return "T_TRY";
        else if("typeof".equals(word)) return "T_TYPEOF";
        else if("uint".equals(word)) return "T_UINT";
        else if("ulong".equals(word)) return "T_ULONG";
        else if("unchecked".equals(word)) return "T_UNCHECKED";
        else if("unsafe".equals(word)) return "T_UNSAFE";
        else if("ushort".equals(word)) return "T_USHORT";
        else if("using".equals(word)) return "T_USING";
        else if("using static".equals(word)) return "T_USING_STATIC";
        else if("virtual".equals(word)) return "T_VIRTUAL";
        else if("void".equals(word)) return "T_VOID";
        else if("volatile".equals(word)) return "T_VOLATILE";

        else if("&&".equals(word)) return "T_OPERATOR_AND";
        else if("&".equals(word)) return "T_OPERATOR_AND";
        else if("||".equals(word)) return "T_BOOLEAN_OR";
        else if("|".equals(word)) return "T_OPERATOR_OR";
        else if("^".equals(word)) return "T_OPERATOR_XOR";
        else if("!".equals(word)) return "T_OPERATOR_NEGATIVE";
        else if("<".equals(word)) return "T_OPERATOR_LESS";
        else if(">".equals(word)) return "T_OPERATOR_GREATER";
        else if("++".equals(word)) return "T_OPERATOR_INCRE";
        else if("--".equals(word)) return "T_OPERATOR_DECRE";
        else if("<<".equals(word)) return "T_LEFT_BIT";
        else if(">>".equals(word)) return "T_RIGHT_BIT";
        else if("==".equals(word)) return "T_OPERATOR_EQUAL";
        else if("!=".equals(word)) return "T_OPERATOR_UNEQUAL";
        else if("<=".equals(word)) return "T_OPERATOR_LTE";
        else if(">=".equals(word)) return "T_OPERATOR_GTE";
        else if("+=".equals(word)) return "T_OPERATOR_ADDASSIGN";
        else if("-=".equals(word)) return "T_OPERATOR_SUBASSIGN";
        else if("*=".equals(word)) return "T_OPERATOR_MULTIASSIGN";
        else if("%=".equals(word)) return "T_OPERATOR_DIVIASSIGN";
        else if("-=".equals(word)) return "T_OPERATOR_SUBASSIGN";
        else if("%=".equals(word)) return "T_OPERATOR_MODASSIGN";
        else if("&=".equals(word)) return "T_OPERATOR_ANDASSIGN";
        else if("|=".equals(word)) return "T_OPERATOR_ORASSIGN";
        else if("^=".equals(word)) return "T_OPERATOR_XORASSIGN";
        else if("<<=".equals(word)) return "T_OPERATOR_LSASSIGN";
        else if(">>=".equals(word)) return "T_OPERATOR_SUBASSIGN";
        return word;
    }
}
