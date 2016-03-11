/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import ninja.Context;
import ninja.Result;
import ninja.Results;
import models.Game;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }
<<<<<<< HEAD
=======

    public Result blackjack() {
        return Results.html().template("views/Blackjack/Blackjack.flt.html");
    }
>>>>>>> edit backend

    public Result gameGet() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        return Results.json().render(g);
    }

    public Result dealPost(Context context, Game g) {
        g.newRound();
        g.deal(g.player);
        g.deal(g.dealer);
        g.deal(g.player);
        g.deal(g.dealer);
        return Results.json().render(g);
    }

    public Result hit(Context context, Game g) {
        if (g.player.sumOfCard < 22) {
            g.deal(g.player);
        }
        return Results.json().render(g);
    }

    public Result doubleDown(Context context, Game g) {
        g.doubleDown();
        return Results.json().render(g);
    }

    public Result stay (Context context, Game g) {

        while(g.dealer.allowHit()) {
            g.deal(g.dealer);
        }
        // Dealer done hit new card, now check who wins
        g.endRound();
        return Results.json().render(g);
    }
}
