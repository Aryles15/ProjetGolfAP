package com.generateur_regles_locales.controllers;

import com.generateur_regles_locales.models.*;
import com.generateur_regles_locales.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private SousCategorieRepository sousCategorieRepository;
    @Autowired
    private RegleRepository regleRepository;

    @Autowired
    private UserRepository userRepository;





    @RequestMapping(value = "/connexion", method = RequestMethod.GET)
    public String seconnecter(Model model) {
        return "connexion";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/checkrules", method = RequestMethod.GET)
    public String generateRules(Model model) {
        return "checkregles";
    }


    @RequestMapping("/categories")
    public String categories(Model model) {
        //List<Categorie> categories = categorieRepository.findAll();
        List<Categorie> categories = categorieRepository.orderListcodeCategorie();
        model.addAttribute("categories", categories);
        return "categorie";
    }

    @RequestMapping(value = "/Editeur/changecateg/{id}", method = RequestMethod.GET)
    public String modifCategories(Model model, @PathVariable("id") Long id) {
        Categorie categ = categorieRepository.findById(id).get();
        model.addAttribute("categorie", categ);
        return "changecategorie";
    }

    @RequestMapping(value = "/Editeur/changecategorie/{id}", method = RequestMethod.POST)
    public String modifyCategories(Model model, @PathVariable("id") Long id, @RequestParam("newtitre") String name) {
        Categorie categ = categorieRepository.findById(id).get();
        categ.setTitle(name);
        categorieRepository.save(categ);



        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page


    }

    @RequestMapping(value = "Gestionnaire/newcateg/{id}", method = RequestMethod.GET)
    public String nextCategories(Model model, @PathVariable("id") Long id) {
        Categorie categ = categorieRepository.findById(id).get();

        model.addAttribute("categorie", categ);


        return "newcategorie";
    }

    @RequestMapping(value = "Gestionnaire/newcategorie", method = RequestMethod.POST)
    public String NewCategorie(@RequestParam("NewNameTitle") String newt, @RequestParam("NewNameCode") String newc) {

        Categorie categ = new Categorie();
        categ.setTitle(newt);
        categ.setCode(newc);
        categorieRepository.save(categ);
        //TODO Ajouter if(code exist ==> "Lettre deja existante ")

        return "redirect:/categories";
    }



//////////////////////////////////////////////supp

    @RequestMapping(value = "Admin/categoriedelete/{id}", method = RequestMethod.GET)
    public String DeleteCategorie(Model model, @PathVariable("id") Long id) {
        Categorie categ = categorieRepository.findById(id).get();
        List<SousCategorie> souscatego = sousCategorieRepository.findAllByCategorie(categ);

        for (SousCategorie sous : souscatego) {
            List<Regle> regle = regleRepository.findAllBySouscategorie(sous);
            for (Regle reg : regle) {
                regleRepository.delete(reg);
            }
            sousCategorieRepository.delete(sous);
        }

        categorieRepository.deleteById(id);

        return "redirect:/categories";
    }









}

