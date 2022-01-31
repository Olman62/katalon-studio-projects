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
import postsPackage.PostClass
import groovy.json.JsonSlurper as JsonSlurper

def jsonSlurper = new JsonSlurper()

'Update an entire post'
def updatedPostResponse = WS.sendRequest(findTestObject('Update Entire Post', [('id') : '1']))

WS.verifyResponseStatusCode(updatedPostResponse, 200)

def updatedPostObject = jsonSlurper.parseText(updatedPostResponse.responseText)

assert 'The updatedPostObject is null' && updatedPostObject!=null

def updatedPost = updatedPostObject as PostClass

postClassName=updatedPost.getClass().getName()

assert 'the value postClassName is not type of postsPackage.PostClass' && postClassName=='postsPackage.PostClass'

assert ('The post ID is not 1') && updatedPost.id==1
assert ('The updated post title is not modified') && updatedPost.title=='A test post modified'
