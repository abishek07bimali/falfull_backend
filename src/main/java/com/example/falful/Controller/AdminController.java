package com.example.falful.Controller;
import com.example.falful.entity.Contact;
import com.example.falful.entity.Items;
import com.example.falful.entity.Order;
import com.example.falful.entity.ShippingAddress;
import com.example.falful.pojo.ItemsPojo;
import com.example.falful.service.ContactService;
import com.example.falful.service.ItemsServices;
import com.example.falful.service.OrderServices;
import com.example.falful.service.ShippingServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private  final ItemsServices itemsServices;
    private  final ContactService contactService;
    private  final ShippingServices shippingServices;
    private  final OrderServices orderServices;




    //
//    ----Add items-----
//
    @GetMapping("/additems")
    public String getAddItemsForm(Model model) {
        model.addAttribute("items", new ItemsPojo());
        return "Admin/addItems";
    }

    @PostMapping("/saveitems")
    public String saveItems(@Valid ItemsPojo itemsPojo,BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/admin/additems";
        }
        itemsServices.save(itemsPojo);
        redirectAttributes.addFlashAttribute("successMsg", "Items saved successfully");
        return "redirect:/admin/viewallproduct";
    }


//
//
//    ==== product =====
// ViewBillingaddress
    @GetMapping("/viewallproduct")
    public String getShop(Model model) {
        List<Items> items = itemsServices.fetchAll();
        model.addAttribute("allproduct", items.stream().map(item ->
                Items.builder()
                        .id(item.getId())
                        .imageBase64(getImageBase64(item.getImage()))
                        .price(item.getPrice())
                        .items_name(item.getItems_name())
                        .quantity(item.getQuantity())
                        .build()
        ));
//        model.addAttribute("allproduct", items);
        return "Admin/MyItems";
    }

    @GetMapping("/editproduct/{id}")
    public String editBlog(@PathVariable("id") Integer id, Model model) {
        Items items = itemsServices.fetchById(id);
        model.addAttribute("items", new ItemsPojo(items));
        return "Admin/addItems";
    }

    @GetMapping("/deleteItems/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        itemsServices.deleteById(id);
        return "redirect:/admin/viewallproduct";
    }

//
//    --- view contact ---
//
//  ----- fetch All contact -----
//
    @GetMapping("/allcontact")
    public String getContactList(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("allcontact", contacts);
        return "Admin/ContactList";
    }
    @GetMapping("/deletecontact/{id}")
    public String deleteContact(@PathVariable("id") Integer id) {
        contactService.deleteById(id);
        return "redirect:/admin/allcontact";
    }

//
//    --- view all shipping---
//
    @GetMapping("/viewallshipping")
    public String getShippingList(Model model) {
    List<ShippingAddress> shippingAddresses = shippingServices.findAll();
        model.addAttribute("allshipping", shippingAddresses);

    return "Admin/ViewShipping";
}

    @GetMapping("/ViewBillingaddress")
    public String getBillingList(Model model) {
        List<ShippingAddress> shippingAddresses = shippingServices.findAll();
        model.addAttribute("allbills", shippingAddresses);

        return "Admin/ViewBillingdetails";
    }



    //
//    --- view all orders---
//
    @GetMapping("/viewallorders")
    public String getAllOrder(Model model) {
        List<Order> orders = orderServices.fetchAll();
        model.addAttribute("allorders", orders);
        return "Admin/ViewOrder";
    }




    @GetMapping("/admindas")
    public String getAbout() {
        return "Admin/dashboard";
    }



    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/fruit_images/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }

}