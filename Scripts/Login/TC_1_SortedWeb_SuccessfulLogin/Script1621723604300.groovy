import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

try {
	WebUI.openBrowser('')
	
	WebUI.navigateToUrl('https://stagweb.gosorted.com/')
	
	WebUI.click(findTestObject('Object Repository/Login/LoginButton'))
	
	WebUI.click(findTestObject('Object Repository/Login/LoginUsingEmail'))
	
	WebUI.setText(findTestObject('Object Repository/Login/EmailTextField'), 'sachin@gosorted.com')
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Login/PasswordTextField'), 'iUHyeRpZ8LLdpMUyOO0ujg==')
	
	WebUI.click(findTestObject('Object Repository/Login/ProceedButton'))
	
	WebUI.click(findTestObject('Object Repository/ToolBar/ProfileIcon'))
	
	WebUI.click(findTestObject('Object Repository/ToolBar/LogoutMenu'))
	
} finally {
	WebUI.closeBrowser()
}

