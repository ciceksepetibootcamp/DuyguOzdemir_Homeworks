using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Interactions;
using NUnit.Framework;
using SeleniumExtras.PageObjects;
using dotNET_HW2.TestClasses;


namespace dotNET_HW2.PageObjects {

  public class HomePage : BasePage {
      public HomePage (IWebDriver driver) {
        HomePage.driver = driver;
        PageFactory.InitElements(driver,this);
      }

    public void searchProduct(String Item){
        IWebElement searchTextBox = driver.FindElement(By.XPath("//input[@id='txtbxArama']"));
        searchTextBox.Click();
        searchTextBox.SendKeys(Item);
        searchTextBox.SendKeys(Keys.Enter);
    }
       public void selectProduct(){
         IWebElement selectProduct = driver.FindElement(By.XPath("//*[@id='ProductPageProductList']/div[1]"));
         selectProduct.Click();
    
    }
    public void selectProductSize(){
         IWebElement selectProductSize = driver.FindElement(By.XPath("//span[.='No:1']"));
         selectProductSize.Click();
    
    }
    public void addToBasket(){
          
        IWebElement addToBasketButton = driver.FindElement(By.XPath("//input[@class='Addtobasket button btnAddBasketOnDetail']"));
        addToBasketButton.Click();
    
    }
     public void completeShopping(){
        IWebElement completeShoppingButton = driver.FindElement(By.XPath("//div[@class='ticiNotyBtn ticiNotyBtnConfirm']"));
        completeShoppingButton.Click();
    
    }

    public void checkOnBasket(){
        IWebElement onBasketItem = driver.FindElement(By.XPath("//a[@id='mainHolder_ucSepetim_btnSepetiTemizle']"));
        onBasketItem.GetAttribute("textContent");   

    }

  }
}