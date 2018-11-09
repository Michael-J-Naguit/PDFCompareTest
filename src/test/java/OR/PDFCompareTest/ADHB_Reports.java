package OR.PDFCompareTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import de.redsix.pdfcompare.PdfComparator;
public class ADHB_Reports {

	@DataProvider(name = "reportname")
	public Object[] createData() {
		return new Object[] {
				"AnaestheticRecord.pdf"
		};
	}
	
	@Test(dataProvider="reportname")
	public void AnaestheticRecord(String ReportName) throws IOException {
		
		String Expectedfile = "C:\\eclipse-workspace\\PDFCompareTest\\ExpectedFiles\\ADHB\\"+ReportName;
		String Actualfile = "C:\\eclipse-workspace\\PDFCompareTest\\ActualFiles\\ADHB\\"+ReportName;
		String Resultfile = "C:\\eclipse-workspace\\PDFCompareTest\\ResultFiles\\ADHB\\"+ReportName;
		
		@SuppressWarnings("rawtypes")
		boolean isEquals = new PdfComparator(Expectedfile, Actualfile).compare().writeTo(Resultfile);
		if (!isEquals) {
		    System.out.println("Differences found! at: "+ReportName);
		}
		AssertJUnit.assertTrue(isEquals);
		
	}
	
}
