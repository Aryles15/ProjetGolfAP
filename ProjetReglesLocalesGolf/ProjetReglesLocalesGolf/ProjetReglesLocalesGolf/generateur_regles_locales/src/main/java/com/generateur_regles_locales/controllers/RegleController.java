package com.generateur_regles_locales.controllers;

import com.generateur_regles_locales.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegleController {

    @Autowired
    private CategorieRepository categorieRepository;
    private SousCategorieRepository sousCategorieRepository;
    private RegleRepository regleRepository;

    @RequestMapping(value = "Editeur/changeregle/{id}", method = RequestMethod.GET)
    public String modifyRegles(Model model, @PathVariable("id") Long id) {
        Regle regle = regleRepository.findById(id).get();

        model.addAttribute("regle", regle);

        return "changeregle";
    }

    @RequestMapping(value = "Editeur/changeregleformulaire/{id}", method = RequestMethod.POST)
    public String modifyRegle(Model model, @PathVariable("id") Long id, @RequestParam("newregle") String corpus) {
        Regle regle = regleRepository.findById(id).get();
        regle.setCorpus(corpus);
        regleRepository.save(regle);

        model.addAttribute("regle", regle);

        return "redirect:/categories";// on respect le prg ,
        // a chaque fois quon influe lapp ou bdd
        //on redirige jamais sur la meme page


    }

    @RequestMapping(value = "Gestionnaire/newnextregle/{id}", method = RequestMethod.GET)
    public String nextRegles(Model model, @PathVariable("id") Long id) {
        SousCategorie souscateg = sousCategorieRepository.findById(id).get();
        SousCategorie listregle = sousCategorieRepository.findById(id).get();
        Integer attributnumordre = listregle.getRegles().size() + 1;
        model.addAttribute("souscategorie", souscateg);
        model.addAttribute("incrementnumordre", attributnumordre);

        return "newregle";
    }


    @RequestMapping(value = "Gestionnaire/newregletexte/{id}", method = RequestMethod.POST)
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

    //supp
    @RequestMapping(value = "Admin/regledelete/{id}", method = RequestMethod.GET)
    public String DeleteRegle(Model model, @PathVariable("id") Long id) {

        Regle regles = regleRepository.findById(id).get();
        regleRepository.delete(regles);

        return "redirect:/categories";
    }


}
