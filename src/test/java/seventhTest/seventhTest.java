package seventhTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

class seventhTest {


    @Test
    void testReadFilesFromZip() throws Exception {
        ZipFile zf = new ZipFile("src/test/resources/files.zip");
        Enumeration<? extends ZipEntry> entries = zf.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            String name = entry.getName();
            try (InputStream inputStream = zf.getInputStream(entry)) {
                if (name.contains(".xlsx")) {
                    XLS xlsFile = new XLS(inputStream);
                    String cellValue = xlsFile.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
                    assertThat(cellValue.contains("PS4"));
                } else if (name.contains(".pdf")) {
                    PDF pdfFile = new PDF(inputStream);
                    assertThat(pdfFile.text.contains("This is a small demonstration .pdf file"));
                } else if (name.contains(".csv")) {
                    CSVReader csvFile = new CSVReader(new InputStreamReader(inputStream));
                    List<String[]> list = csvFile.readAll();
                    assertThat(list.get(0)[1].equals("Doe"));
                }
            }

        }
    }
}
