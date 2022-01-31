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
import internal.GlobalVariable
import postsPackage.PostClass

import org.openqa.selenium.Keys as Keys

import groovy.json.JsonSlurper as JsonSlurper

def jsonSlurper = new JsonSlurper()

'Get Post by ID request'
def postResponse = WS.sendRequest(findTestObject('Get Post by ID', [('id') : '1']))

WS.verifyResponseStatusCode(postResponse, 200)

def postObject = jsonSlurper.parseText(postResponse.responseText)

assert 'The postObject is null' && postObject!=null

def post = postObject as PostClass

postClassName=post.getClass().getName()

assert 'the value postClassName is not type of postsPackage.PostClass' && postClassName=='postsPackage.PostClass'

assert ('The post ID is not 1') && post.id==1

printf("Post class name: %s \n", postClassName)

printf("Post ID: %d \n", post.id)

