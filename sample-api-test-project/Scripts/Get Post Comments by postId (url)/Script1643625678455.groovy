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
import groovy.json.JsonSlurper as JsonSlurper
import postsPackage.PostCommentClass

def jsonSlurper = new JsonSlurper()

'Get the post comments by URL parameter postId'
postCommentsResponse = WS.sendRequest(findTestObject('Get Post Comments by postId (url)'))

WS.verifyResponseStatusCode(postCommentsResponse, 200)

List postComments = jsonSlurper.parseText(postCommentsResponse.responseText)
totalComments = postComments.size()

assert ('The comments total is 0') && totalComments>0

def comment1 = postComments[0] as PostCommentClass

commentClassName=comment1.getClass().getName()

assert 'the value commentClassName is not type of postsPackage.PostCommentClass' && commentClassName=='postsPackage.PostCommentClass'
