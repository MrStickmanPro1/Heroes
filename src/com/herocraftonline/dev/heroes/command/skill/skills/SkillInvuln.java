package com.herocraftonline.dev.heroes.command.skill.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

import com.herocraftonline.dev.heroes.Heroes;
import com.herocraftonline.dev.heroes.command.skill.ActiveEffectSkill;
import com.herocraftonline.dev.heroes.persistence.Hero;
import com.herocraftonline.dev.heroes.persistence.HeroEffects;

public class SkillInvuln extends ActiveEffectSkill {

    public SkillInvuln(Heroes plugin) {
        super(plugin);
        name = "Invuln";
        description = "Grants total damage immunity";
        usage = "/skill invuln";
        minArgs = 0;
        maxArgs = 0;
        identifiers.add("skill invuln");

        registerEvent(Type.ENTITY_DAMAGE, new SkillEntityListener(), Priority.Normal);
    }

    @Override
    public boolean use(Hero hero, String[] args) {
        Player player = hero.getPlayer();
        String playerName = player.getName();
        applyEffect(hero);

        notifyNearbyPlayers(player.getLocation(), useText, playerName, name);
        return true;
    }

    public class SkillEntityListener extends EntityListener {

        @Override
        public void onEntityDamage(EntityDamageEvent event) {
            if (event.isCancelled()) {
                return;
            }

            Entity defender = event.getEntity();
            if (defender instanceof Player) {
                Player player = (Player) defender;
                HeroEffects effects = plugin.getHeroManager().getHero(player).getEffects();
                if (effects.hasEffect(name)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
