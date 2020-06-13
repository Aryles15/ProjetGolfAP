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





    @RequestMapping(value = "/connexion", method = RequestMethod.GET)
    public String seconnecter(Model model) {
        return "connexion";
    }

    @RequestMapping("/categories")
    public String categories(Model model) {
        List<Categorie> categories = categorieRepository.findAll();
        model.addAttribute("categories", categories);
        return "categorie";
    }
////////////////////////////////////Categorie

    @RequestMapping(value = "/changecateg/{id}", method = RequestMethod.GET)
    public String modifCategories(Model model, @PathVariable("id") Long id) {
        Categorie categ = categorieRepository.findById(id).get();
        model.addAttribute("categorie", categ);
        return "changecategorie";
    }

    @RequestMapping(value = "/changecategorie/{id}", method = RequestMethod.POST)
    public String modifyCategories(Model model, @PathVariable("id") Long id, @RequestParam("newtitre") String name) {
        Categorie categ = categorieRepository.findById(id).get();
        categ.setTitle(name);
        categorieRepository.save(categ);

        model.addAttribute("categories", categ);

        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page


    }

    @RequestMapping(value = "/newcateg/{id}", method = RequestMethod.GET)
    public String nextCategories(Model model, @PathVariable("id") Long id) {
        Categorie categ = categorieRepository.findById(id).get();

        model.addAttribute("categorie", categ);


        return "newcategorie";
    }

    @RequestMapping(value = "/newcategorie", method = RequestMethod.POST)
    public String NewCategorie(@RequestParam("NewNameTitle") String newt, @RequestParam("NewNameCode") String newc) {

        Categorie categ = new Categorie();
        categ.setTitle(newt);
        categ.setCode(newc);
        categorieRepository.save(categ);
        //TODO Ajouter if(code exist ==> "Lettre deja existante ")

        return "redirect:/categories";
    }

    //////////////////////////////////////////SousCategorie

    @RequestMapping(value = "/changesouscateg/{id}", method = RequestMethod.GET)
    public String modifSousCategories(Model model, @PathVariable("id") Long id) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        model.addAttribute("souscategorie", souscateg);
        return "changesouscategorie";
    }

    @RequestMapping(value = "/changesouscategorie/{id}", method = RequestMethod.POST)
    public String modifySousCategories(Model model, @PathVariable("id") Long id, @RequestParam("newtitre") String name) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        souscateg.setTitle(name);
        sousCategorieRepository.save(souscateg);

        model.addAttribute("souscategories", souscateg);

        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page


    }

    @RequestMapping(value = "/changesouscategobjet/{id}", method = RequestMethod.GET)
    public String modifSousCategoriesObject(Model model, @PathVariable("id") Long id) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        model.addAttribute("souscategorie", souscateg);
        return "changesouscategorieobjet";
    }

    @RequestMapping(value = "/changesouscategorieobjet/{id}", method = RequestMethod.POST)
    public String modifySousCategoriesObject(Model model, @PathVariable("id") Long id, @RequestParam("newobjet") String objet) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        souscateg.setObjet(objet);
        sousCategorieRepository.save(souscateg);

        model.addAttribute("souscategories", souscateg);

        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page


    }

    @RequestMapping(value = "/newsouscateg/{id}", method = RequestMethod.GET)
    public String nextNewCategories(Model model, @PathVariable("id") Long id) {
        Categorie categ = categorieRepository.findById(id).get();
        Categorie listsouscategorie = categorieRepository.findById(id).get();
        Integer attributnumordre = listsouscategorie.getSousCategories().size() + 1;
        model.addAttribute("categorie", categ);
        model.addAttribute("incrementnumordre", attributnumordre);


        return "newsouscategorie";
    }

    @RequestMapping(value = "/newsouscategorie/{id}", method = RequestMethod.POST)
    public String NewSousCategorie(@RequestParam("newnumordre") Integer newnumordre, @PathVariable("id") Long id, @RequestParam("NewTitle") String newtitle, @RequestParam("newobjet") String newobjet) {
        Categorie categ = categorieRepository.findById(id).get();
        SousCategorie souscateg = new SousCategorie();//new souscateg sur lid de la categorie

        //on set tous les attribut recupuerer et necessaire à l'affichage du template categorie
        souscateg.setObjet(newobjet);
        souscateg.setTitle(newtitle);
        souscateg.setNumordre(newnumordre);
        souscateg.setCategorie(categ);//on set la souscateg a la nouvelle categorie
        categ.getSousCategories().add(souscateg);//on ajoute a la categorie la nouvelle sous categ
        categorieRepository.save(categ);//on save
        sousCategorieRepository.save(souscateg);

        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page
    }


    //////////////////////////////////////////Regle
    @RequestMapping(value = "/changeregle/{id}", method = RequestMethod.GET)
    public String modifyRegles(Model model, @PathVariable("id") Long id) {
        Regle regle = regleRepository.findById(id).get();

        model.addAttribute("regle", regle);

        return "changeregle";
    }

    @RequestMapping(value = "/changeregleformulaire/{id}", method = RequestMethod.POST)
    public String modifyRegle(Model model, @PathVariable("id") Long id, @RequestParam("newregle") String corpus) {
        Regle regle = regleRepository.findById(id).get();
        regle.setCorpus(corpus);
        regleRepository.save(regle);

        model.addAttribute("regle", regle);

        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page


    }

    @RequestMapping(value = "/newnextregle/{id}", method = RequestMethod.GET)
    public String nextRegles(Model model, @PathVariable("id") Long id) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        SousCategorie listregle = sousCategorieRepository.findById(id).get();
        Integer attributnumordre = listregle.getRegles().size() + 1;
        model.addAttribute("souscategorie", souscateg);
        model.addAttribute("incrementnumordre", attributnumordre);

        return "newregle";
    }


    @RequestMapping(value = "/newregletexte/{id}", method = RequestMethod.POST)
    public String NewRegle(Model model, @PathVariable("id") Long id, @RequestParam("NewTitle") String newtitle, @RequestParam("newnumordre") Integer newnumordre, @RequestParam("newcorpus") String newcorpus) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        Regle regle = new Regle();
        regle.setCorpus(newtitle);
        regle.setNumordre(newnumordre);
        regle.setCorpus(newcorpus);
        regle.setSouscategorie(souscateg);
        sousCategorieRepository.save(souscateg);
        regleRepository.save(regle);

        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page
    }

//////////////////////////////////////////////Delate

    @RequestMapping(value = "/categoriedelete/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/souscategoriedelete/{id}", method = RequestMethod.GET)
    public String DeleteSousCategorie(Model model, @PathVariable("id") Long id) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        List<Regle> regle = regleRepository.findAllBySouscategorie(souscateg);

        for (Regle reg : regle) {
            regleRepository.delete(reg);
        }
        sousCategorieRepository.delete(souscateg);

        return "redirect:/categories";
    }

    @RequestMapping(value = "/regledelete/{id}", method = RequestMethod.GET)
    public String DeleteRegle(Model model, @PathVariable("id") Long id) {

        Regle regles = regleRepository.findById(id).get();
        regleRepository.delete(regles);

        return "redirect:/categories";
    }


    @RequestMapping(value = "/regleselect", method = RequestMethod.POST)
    public String SelectRegle(Model model, @RequestParam("idregles") List<Long> listidregle) {  //On recupere une Liste contenant les id des règles selectionné

        if (listidregle.size() > 0) {
            List<Regle> Listregleselect = new ArrayList<>();

            for (Long id : listidregle) {
                Listregleselect.add(regleRepository.findById(id).get());
            }
            for (Regle regle : Listregleselect) {
                System.out.println("===============================================" + regle.getCorpus());
            }

            model.addAttribute("listeregles", Listregleselect);
            return "checkregles";
        } else {
            System.out.println("Pas d'id");
            return "categorie";
        }
    }


}

