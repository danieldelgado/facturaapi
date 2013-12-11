/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facturasapi.rest.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.UnicodeEscaper;
import org.apache.commons.lang3.text.translate.UnicodeUnescaper;

/**
 *
 * @author Javier
 */
public class UnicodeUtil {

    public static String unicodeCadenaString(String cadena) {
        UnicodeEscaper escaper = UnicodeEscaper.above(127);
        return escaper.translate(cadena);
    }

    public static String desUnicodeCadenaString(String cadena) {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        return unescaper.translate(cadena);
    }

    public static String fileXMLtoString(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line.trim());
        }
        return sb.toString();
    }

    public static File xMLStringToFile(String xml, File file) throws IOException {
        FileWriter fr = new FileWriter(file);
        Writer br = new BufferedWriter(fr);
        br.write(xml);
        br.close();
        return file;
    }
}
