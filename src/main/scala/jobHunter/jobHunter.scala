/*
 * Copyright (c) 2011-2017, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package jobHunter

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry._
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.event.ActionEvent
import scalafx.stage.FileChooser
import scala.io.Source
import scalafx.collections.ObservableBuffer
import scala.util.control.Breaks._
 
object JobHunterSBT extends JFXApp {
    // abstract class Company{
    //     def companyName:String 
    //     def contactName:String 
    //     def contactPhone:String 
    //     def contactEmail:String
    //     def status:String
    //     def notes:String
    // }
    // case class TechCompany(
    //     companyName:String, 
    //     contactName:String, 
    //     contactPhone:String, 
    //     contactEmail:String,
    //     status:String,
    //     companyType:String,
    //     notes:String        
    // ) extends Company
    // case class RecruitingCompany(
    //     companyName:String, 
    //     contactName:String, 
    //     contactPhone:String, 
    //     contactEmail:String,
    //     status:String,
    //     companyType:String,
    //     notes:String       
    // ) extends Company
        case class Company(
        companyName:String, 
        contactName:String, 
        contactPhone:String, 
        contactEmail:String,
        status:String,
        companyType:String,
        notes:String        
    )


    // var companies = Array[Company](Company("jared industries", "jared", "555-555-5555", "jared@jared.com", "tech", "applied", "Great Company!"),
    //     Company("Guy Electronics", "William", "777-777-7777", "will@theguy.com", "tech", "follow up needed", "What a good guy!"),
    //     Company("Sheesh Burger", "Mia", "888-888-8888", "theMonster@shoe.com", "recruiter", "denied", "Such an attitude!"))

    /*
    //Temp records
    Company("jared industries", "jared", "555-555-5555", "jared@jared.com", "applied", "Great Company!", "tech")
    Company("Guy Electronics", "William", "777-777-7777", "will@theguy.com", "follow up needed", "What a good guy!", "tech")
    Company("Sheesh Burger", "Mia", "888-888-8888", "theMonster@shoe.com", "denied", "Such an attitude!", "recruiter")
    */

    var allCompanies = Array[Company]()

    var techArray = Array[Company](Company("jared industries", "jared", "555-555-5555", "jared@jared.com", "applied", "tech", "Great Company!"),
        Company("Guy Electronics", "William", "777-777-7777", "will@theguy.com", "follow up needed", "tech", "What a good guy!")
    )
    var recruiterArray = Array[Company](Company("Sheesh Burger", "Mia", "888-888-8888", "theMonster@shoe.com", "denied", "recruiter", "Such an attitude!"),
        Company("Eating Good Now", "Ali", "222-222-2222", "ali@thebest.com", "denied", "recruiter", "Of the highest quality!")
    )

    val techList:ListView[String] = new ListView(techArray.map(_.companyName))
    techList.selectionModel.apply.selectedItems.onChange {
            val index = techList.selectionModel.apply.selectedIndices.toSeq
            val company = techArray(index(0))
            gpTopCompanyTF.text = company.companyName
            gpTopContactTF.text = company.contactName
            gpTopPhoneTF.text = company.contactPhone
            gpTopEmailTF.text = company.contactEmail
            val status = company.status
            //val companyType = company.companyType
            techRB.setSelected(true)
            var i = 0
            // breakable {
            //     while (i < rbTG.getToggles.size) {
            //         val button = rbTG.getToggles.get(i).asInstanceOf[RadioButton]
            //         val btnText = button.text
            //         if (btnText == status) {
            //             button.setSelected(true)
            //             break
            //         }
            //         i += 1
            //     }
            // }
            // for(t <- rbTG.toggles){
            //     if(t.text == "Recruiter"){
            //         t.toggle
            //     }
            // }
            notesTextArea.text = company.notes

            //clear selections in recruiter ListView
            if(!recruiterList.selectionModel.apply.isEmpty){
                val index = recruiterList.selectionModel.apply.selectedIndices.toSeq
                recruiterList.selectionModel.apply.clearSelection(index(0))
            }
            //recruiterList.selectionModel.apply.clearSelection
            //println(index)
    }

    // val statusCB = new ComboBox(List("Follow Up Required", "Offer Extended", "Declined"))
    // statusCB.promptText = "Select Status"
        
        //model.selectionMode = SelectionMode.Single
        // var index = model.selectedItem
        // val company = allCompanies(index)
        // gpTopCompanyTF.text = company.companyName
    
    val recruiterList = new ListView(recruiterArray.map(_.companyName))
    recruiterList.selectionModel.apply.selectedItems.onChange {
            val index = recruiterList.selectionModel.apply.selectedIndices.toSeq
            val company = recruiterArray(index(0))
            gpTopCompanyTF.text = company.companyName
            gpTopContactTF.text = company.contactName
            gpTopPhoneTF.text = company.contactPhone
            gpTopEmailTF.text = company.contactEmail
            val status = company.status
            //val companyType = company.companyType
            //techRB.selected = false
            recruiterRB.setSelected(true)

            // for(t <- rbTG.toggles){
            //     if(t.text == "Recruiter"){
            //         t.toggle
            //     }
            // }
            notesTextArea.text = company.notes

            //clear selections in tech ListView
            if(!techList.selectionModel.apply.isEmpty){
                val index = techList.selectionModel.apply.selectedIndices.toSeq
                techList.selectionModel.apply.clearSelection(index(0))
            }
            //println(index)
    }

    // def populateTechListView():Array[String] = {
    //     techList.items = techArray.map(_.companyName)
    // }

    // def populateRecListView():Array[String] = {
    //     recruiterList = recruiterArray.map(_.companyName)
    // }

    def sortCompanies() = {
        // println("inside sortCompanies")
        // println("isEmpty: " + allCompanies.isEmpty)
        // println("allCompanies size: " + allCompanies.size)
        // allPrint(allCompanies)
        for(c <- allCompanies){
            if(c.companyType == "tech"){
                println("inside if")
                techArray :+= c
            }
            else {
                println("inside else")
                recruiterArray :+= c
            }
        }
        tecPrint(techArray)
        recPrint(recruiterArray)
        // println("end of sortCompanies")
    }

    // def allPrint(arr:Array[Company]) = {
    //     println("inside allPrint")
    //     for(x <- arr){
    //         println(x.companyName)
    //     }
    //     println("end allPrint")
    // }

    def tecPrint(arr:Array[Company]) = {
        // println("inside techPrint")
        println("isEmpty: " + techArray.isEmpty)
        println("techCompanies size: " + techArray.size)
        println("tech companies:")
        for(x <- arr){
            println(x.companyName)
        }
        // println("end tecPrint")
    }

    def recPrint(arr:Array[Company]) = {
        // println("inside recPrint")
        println("isEmpty: " + recruiterArray.isEmpty)
        println("recCompanies size: " + recruiterArray.size)
        println("tech companies:")
        for(x <- arr){
            println(x.companyName)
        }
        // println("end recPrint")
    }

    //create top GridPane and gpTop elements
    val gpTopCompanyLabel = new Label("Company Name: ")
    val gpTopCompanyTF:TextField = new TextField{

    }
    // val gpTopCompany = new BorderPane
    // gpTopCompany.left = gpTopCompanyLabel
    // gpTopCompany.center = gpTopCompanyTF

    val gpTopContactLabel = new Label("Contact Name: ")
    val gpTopContactTF = new TextField
    // val gpTopContact = new BorderPane
    // gpTopContact.left = gpTopContactLabel
    // gpTopContact.center = gpTopContactTF

    val gpTopPhoneLabel = new Label("Contact Phone: ")
    val gpTopPhoneTF = new TextField
    // val gpTopPhone = new BorderPane
    // gpTopPhone.left = gpTopPhoneLabel
    // gpTopPhone.center = gpTopPhoneTF

    val gpTopEmailLabel = new Label("Contact Email: ")
    val gpTopEmailTF = new TextField
    // val gpTopEmail = new BorderPane
    // gpTopEmail.left = gpTopEmailLabel
    // gpTopEmail.center = gpTopEmailTF

    //val gpTopTypeLabel = new Label("Company Type: ")
    val techRB = new RadioButton("Tech Company ")
    techRB.selected = true
    val recruiterRB = new RadioButton("Recruiter")
    val rbTG = new ToggleGroup
    rbTG.toggles = List(techRB, recruiterRB)
    val rbFlowPane = new FlowPane(Orientation.Horizontal)
    rbFlowPane.children += techRB
    rbFlowPane.children += recruiterRB

    val statusCB = new ComboBox(List("Follow Up Required", "Offer Extended", "Declined"))
    statusCB.promptText = "Select Status"

    //create bottom GridPane and gpBtns elements
    val addBtn = new Button("Add")
    val modBtn = new Button("Modify")
    val delBtn = new Button("Delete")     

    val gpBtns = new GridPane
    gpBtns.add(addBtn,1,1)
    gpBtns.add(modBtn,2,1)
    gpBtns.add(delBtn,3,1) 

    //create notes text area
    val notesLabel = new Label("Notes:")
    val notesTextArea = new TextArea 


    //GUI
    stage = new PrimaryStage {
        title = "Job Hunter 1.0"
        // width = 800
        // height = 600
        scene = new Scene(800, 600) {
            val menuBar = new MenuBar  //create menu bar
            val fileMenu = new Menu("File")  //create menu
            //create menu items
            val newItem = new MenuItem("New") 
            val openItem = new MenuItem("Open")
            openItem.onAction = (e:ActionEvent) => {
                val chooser = new FileChooser
                val selectedFile = chooser.showOpenDialog(stage)  //function is passed stage that it will appear ontop of
                if(selectedFile != null){
                    // val techObs = ObservableBuffer
                    // val recruiterObs = ObservableBuffer
                    val source = Source.fromFile(selectedFile)
                    val lines = source.getLines  //non - empty iterator
                    var count = 0
                    val numRecords = lines.next.toInt
                    // println("number of records: " + numRecords)
                    while(count < numRecords){
                        val companyName = lines.next
                        // println("companyName: " + companyName)
                        val contactName = lines.next
                        // println("contactName: " + contactName)
                        val contactPhone = lines.next
                        // println("contactPhone: " + contactPhone)
                        val contactEmail = lines.next
                        // println("contactEmail: " + contactEmail)
                        val status = lines.next
                        // println("status: " + status)
                        val companyType = lines.next
                        // println("companyType: " + companyType)
                        var notes = ""
                        var line = lines.next
                        while(line!="--end notes--"){  //"--end notes--" indicates end of notes in text file
                            notes += line + "\n"
                            line = lines.next
                        }
                        // println("notes: " + notes)
                        allCompanies :+= Company(companyName, contactName, contactPhone, contactEmail, status, companyType, notes)
                        count+=1
                    }
                    source.close
                    sortCompanies
                    // if(companyType == "tech"){
                    //     println("inside if")
                    //     var thisCompany = TechCompany(companyName, contactName, contactPhone, contactEmail, status, companyType, notes)
                    //     techArray :+ thisCompany
                    // }
                    // else {
                    //     println("inside else")
                    //     var thisCompany = RecruitingCompany(companyName, contactName, contactPhone, contactEmail, status, companyType, notes)
                    //     recruiterArray :+ thisCompany
                    // }                    
                    
                    //techArray.foreach {println(techArray.map(_.companyName))}
                    //println(techArray(0).companyName)
                    //println(techArray(1).companyName)
                    //println(recruiterArray(0).companyName)
                    // techList.items.append(techArray.map(_.companyName))
                    // recruiterList.items.append(recruiterArray.map(_.companyName))
                    // populateTechListView
                    // populateRecListView
                    //sortCompanies
                    //refresh Lists
                    //techList.items.get += ObservableBuffer(techArray.map(_.companyName))  //haven't tried yet                  
                    //recruiterList.items = ObservableBuffer(recruiterArray.map(_.companyName))
                }
            }
            val saveItem = new MenuItem("Save")
            saveItem.onAction = (e:ActionEvent) => {
                val chooser = new FileChooser
                val selectedFile = chooser.showSaveDialog(stage)
                if(selectedFile != null){
                    val pw = new java.io.PrintWriter(selectedFile)
                    pw.println(allCompanies.size)
                    for(c <- allCompanies){
                        pw.println(c.companyName)
                        pw.println(c.contactName)
                        pw.println(c.contactPhone)
                        pw.println(c.contactEmail)
                        pw.println(c.status)
                        pw.println(c.companyType)
                        pw.println(c.notes)
                        pw.println("--end notes--")
                    }
                    pw.close
                }
            }
            val exitItem = new MenuItem("Exit")
            exitItem.onAction = (e:ActionEvent) => sys.exit(0)
            fileMenu.items = List(newItem, openItem, saveItem, new SeparatorMenuItem, exitItem)  //add items to menu
            menuBar.menus = List(fileMenu)  //add menu to menu bar


            // val label1 = new Label("company list")
            // val label2 = new Label("recruiter list")
            val leftSPTopLbl = new Label("Tech Companies")
            val techScroll = new ScrollPane
            techScroll.content = techList
            val leftSPTopBP = new BorderPane
            leftSPTopBP.top = leftSPTopLbl
            leftSPTopBP.center = techScroll

            val leftSPBottomLbl = new Label("Recruiters")
            val recruiterScroll = new ScrollPane
            recruiterScroll.content = recruiterList
            val leftSPBottomBP = new BorderPane
            leftSPBottomBP.top = leftSPBottomLbl
            leftSPBottomBP.center = recruiterScroll

            val leftSplitPane = new SplitPane
            leftSplitPane.orientation = Orientation.Vertical  //sets items vertically
            leftSplitPane.items ++= List(leftSPTopBP, leftSPBottomBP) //add items to leftSplitPane
            //leftSplitPane.dividerPositions = 0.5  //set divider position not working
            //leftSplitPane.resize(0.5, 0.5)
            //leftSplitPane.prefHeight = 5.0


            val gpTop = new GridPane
            //gpTop.alignmentInParent = Pos.CENTER
            // gpTop.add(gpTopCompany,1,1)  //element, column, row
            // gpTop.add(gpTopContact,1,2)
            // gpTop.add(gpTopPhone,1,3)
            // gpTop.add(gpTopEmail,1,4)
            gpTop.add(gpTopCompanyLabel,1,1)
            gpTop.add(gpTopCompanyTF,2,1)
            gpTop.add(gpTopContactLabel,1,2)
            gpTop.add(gpTopContactTF,2,2)
            gpTop.add(gpTopPhoneLabel,1,3)
            gpTop.add(gpTopPhoneTF,2,3)
            gpTop.add(gpTopEmailLabel,1,4)
            gpTop.add(gpTopEmailTF,2,4)
            //gpTop.add(gpTopTypeLabel,3,1)
            gpTop.add(rbFlowPane,3,1)
            gpTop.add(statusCB,3,2)
            gpTop.add(gpBtns,3,4)

            
            // val notesScroll = new ScrollPane
            // notesScroll.content = notesTextArea
            val notesBorderPane = new BorderPane
            notesBorderPane.top = notesLabel
            notesBorderPane.center = notesTextArea

            val rightBorderPane = new BorderPane
            rightBorderPane.top = gpTop  //add top GridPane to rightBorderPane
            rightBorderPane.center = notesBorderPane  //add descBorderPane to rightBorderPane
            //rightBorderPane.right = gpBtns  //add bottom GridPane to rightBorderPane     

            val mainSplitPane = new SplitPane  //create mainSplitPane
            mainSplitPane.items ++= List(leftSplitPane, rightBorderPane)  //add items to mainSplitPane
            mainSplitPane.dividerPositions = 0.175  //set divider position

            val rootPane = new BorderPane  //create rootPane
            rootPane.top = menuBar  //add menuBar to top of rootPane
            rootPane.center = mainSplitPane  //add mainSplitPane to center of rootPane
            root = rootPane  //display rootPane
       }
    }
}