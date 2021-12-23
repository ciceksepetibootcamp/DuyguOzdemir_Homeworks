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

  public class BasketPage : BasePage {
    public BasketPage (IWebDriver driver) {
        BasketPage.driver = driver;
        PageFactory.InitElements(driver,this);
      }

    public void removeFromBasket(){
        HomePage homepage = new HomePage(driver);   
        IWebElement removeProduct = driver.FindElement(By.XPath("//*[@id='mainHolder_ucSepetim_rptSepet_lnkBtnUrunSil_0']"));
        removeProduct.Click();
    }

  }
}