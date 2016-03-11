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


@Singleton
public class ApplicationController {

    public Result index() {

        return Results.html();

    }

    public Result gameGet() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();
        g.error=false;

        return Results.json().render(g);
    }

    public Result dealPost(Context context, Game g) {
        if(context.getRequestPath().contains("deal")){
            g.dealTwo();
        }
        return Results.json().render(g);
    }

    public static class SimplePojo {

        public String content;
        
    }
}
