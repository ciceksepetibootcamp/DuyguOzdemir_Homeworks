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

namespace dotNET_HW2.TestClasses {

  public class BasePage{
    public static IWebDriver driver;

    public void Initialize() {
        driver = new ChromeDriver();
        driver.Manage().Window.Maximize();
        driver.Url = "https://www.livashop.com/";
        
    }

    public void TearDown() {
        driver.Quit();
      }
  }
}