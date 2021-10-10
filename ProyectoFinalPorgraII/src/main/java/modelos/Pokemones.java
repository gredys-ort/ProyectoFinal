/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Wcastañeda
 */
public class Pokemones {
private String id;
private String name;
private String species;
private String color;
private String habitat;
private String gender_rate;
private String capture_rate;
private String base_experience;
private String forme_name;
private String forme_base_pokemon_id;
private String generation_id;
private String evolution_chain_id;
private String evolution_parent_pokemon_id;
private String evolution_method_id;
private String evolution_parameter;
private String height;
private String weight;
private String pokemon_shape_id;
private String base_happiness;
private String gen1_internal_id;
private String is_baby;
private String has_gen4_fem_sprite;
private String has_gen4_fem_back_sprite;

    public Pokemones(String id, String name, String species, String color, String habitat, String gender_rate, String capture_rate, String base_experience, String forme_name) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.color = color;
        this.habitat = habitat;
        this.gender_rate = gender_rate;
        this.capture_rate = capture_rate;
        this.base_experience = base_experience;
        this.forme_name = forme_name;
    }

    @Override
    public String toString() {
        return "Pokemones{" + "id=" + id + ", name=" + name + ", forme_name=" + forme_name + ", forme_base_pokemon_id=" + forme_base_pokemon_id + ", generation_id=" + generation_id + ", evolution_chain_id=" + evolution_chain_id + ", evolution_parent_pokemon_id=" + evolution_parent_pokemon_id + ", evolution_method_id=" + evolution_method_id + ", evolution_parameter=" + evolution_parameter + ", height=" + height + ", weight=" + weight + ", species=" + species + ", color=" + color + ", pokemon_shape_id=" + pokemon_shape_id + ", habitat=" + habitat + ", gender_rate=" + gender_rate + ", capture_rate=" + capture_rate + ", base_experience=" + base_experience + ", base_happiness=" + base_happiness + ", gen1_internal_id=" + gen1_internal_id + ", is_baby=" + is_baby + ", has_gen4_fem_sprite=" + has_gen4_fem_sprite + ", has_gen4_fem_back_sprite=" + has_gen4_fem_back_sprite + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForme_name() {
        return forme_name;
    }

    public void setForme_name(String forme_name) {
        this.forme_name = forme_name;
    }

    public String getForme_base_pokemon_id() {
        return forme_base_pokemon_id;
    }

    public void setForme_base_pokemon_id(String forme_base_pokemon_id) {
        this.forme_base_pokemon_id = forme_base_pokemon_id;
    }

    public String getGeneration_id() {
        return generation_id;
    }

    public void setGeneration_id(String generation_id) {
        this.generation_id = generation_id;
    }

    public String getEvolution_chain_id() {
        return evolution_chain_id;
    }

    public void setEvolution_chain_id(String evolution_chain_id) {
        this.evolution_chain_id = evolution_chain_id;
    }

    public String getEvolution_parent_pokemon_id() {
        return evolution_parent_pokemon_id;
    }

    public void setEvolution_parent_pokemon_id(String evolution_parent_pokemon_id) {
        this.evolution_parent_pokemon_id = evolution_parent_pokemon_id;
    }

    public String getEvolution_method_id() {
        return evolution_method_id;
    }

    public void setEvolution_method_id(String evolution_method_id) {
        this.evolution_method_id = evolution_method_id;
    }

    public String getEvolution_parameter() {
        return evolution_parameter;
    }

    public void setEvolution_parameter(String evolution_parameter) {
        this.evolution_parameter = evolution_parameter;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPokemon_shape_id() {
        return pokemon_shape_id;
    }

    public void setPokemon_shape_id(String pokemon_shape_id) {
        this.pokemon_shape_id = pokemon_shape_id;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getGender_rate() {
        return gender_rate;
    }

    public void setGender_rate(String gender_rate) {
        this.gender_rate = gender_rate;
    }

    public String getCapture_rate() {
        return capture_rate;
    }

    public void setCapture_rate(String capture_rate) {
        this.capture_rate = capture_rate;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public String getBase_happiness() {
        return base_happiness;
    }

    public void setBase_happiness(String base_happiness) {
        this.base_happiness = base_happiness;
    }

    public String getGen1_internal_id() {
        return gen1_internal_id;
    }

    public void setGen1_internal_id(String gen1_internal_id) {
        this.gen1_internal_id = gen1_internal_id;
    }

    public String getIs_baby() {
        return is_baby;
    }

    public void setIs_baby(String is_baby) {
        this.is_baby = is_baby;
    }

    public String getHas_gen4_fem_sprite() {
        return has_gen4_fem_sprite;
    }

    public void setHas_gen4_fem_sprite(String has_gen4_fem_sprite) {
        this.has_gen4_fem_sprite = has_gen4_fem_sprite;
    }

    public String getHas_gen4_fem_back_sprite() {
        return has_gen4_fem_back_sprite;
    }

    public void setHas_gen4_fem_back_sprite(String has_gen4_fem_back_sprite) {
        this.has_gen4_fem_back_sprite = has_gen4_fem_back_sprite;
    }
    
}
