/*
 * UserWebService
 */

package com.jking31cs.jerseyexample.webservices;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jking31cs.jerseyexample.objects.User;
import com.jking31cs.jerseyexample.stores.UserStore;

@Path("api/users")
public class UserWebService {
    
    private final UserStore store;
    
    @Inject
    public UserWebService(UserStore store) {
        this.store = store;
    }
    
    /*
     * Endpoint GET
     * users/
     * Retrieve list of all users
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return store.getAll();
    }
    
    /*
     * Endpoint GET
     * users/id
     * Retrieve user details by ID
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Long id) {
        return store.get(id);
    }
    
    /*
     * Endpoint POST
     * users/
     * @param User
     * Create new user
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User newUser(User user) {
        return store.save(user);
    }
    
    /*
     * Endpoint PUT
     * users/id
     * @param User
     * Update user with ID
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("id") Long id, User user) {
        return store.save(user);
    }
    
    /*
     * Endpoint DELETE
     * users/id
     * Delete user with ID
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("id") Long id) {
        return store.delete(store.get(id));
    }
}
